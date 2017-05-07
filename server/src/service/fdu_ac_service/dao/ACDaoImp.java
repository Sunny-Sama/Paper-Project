package service.fdu_ac_service.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service.fdu_ac_service.model.ACRule;
import service.fdu_ac_service.model.ACUser;
import service.fdu_ac_service.model.Rule;

@Repository("ACDao")
public class ACDaoImp implements ACDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Rule[] getRuleList(long hash, int type) {
		// get ACUsers according to hash and type
		Query query = sessionFactory.getCurrentSession().createQuery("from ACUser au where au.hash = ? AND au.type = ?")
				.setString(0, hash + "").setString(1, type + "");
		List<ACUser> acRules = query.list();

		// set return value
		Rule[] rules = new Rule[acRules.size()];
		for (int i = 0; i < acRules.size(); i++) {
			Rule rule = new Rule(acRules.get(i).getId(), acRules.get(i).getUser_id(), "userName");
			rules[i] = rule;
		}

		return rules;
	}

	@Override
	public long addRule(long hash, long[] tableIds, long userId, long catalog, int type) {

		long rst = 0;
		long ruleId = 0;

		// add ACUser to db
		// TODO: 判断是否已经存在
		Session session = sessionFactory.getCurrentSession();
		ACUser acUser = new ACUser(catalog, userId, type, hash);
		ruleId = (Long) session.save(acUser);

		// add ACRule to db
		for (int i = 0; i < tableIds.length; i++) {
			ACRule acRule = new ACRule(ruleId, tableIds[i]);
			rst = (Long) session.save(acRule);
		}

		return rst;
	}

	@Override
	public long deleteRule(long rule_id) {
		// delete ACUser according to rule_id
		Query query = sessionFactory.getCurrentSession().createQuery("delete ACUser au where au.id = ?").setString(0,
				rule_id + "");

		// TODO: 删除附属表中的内容
		// >0 success
		return query.executeUpdate();
	}

}
