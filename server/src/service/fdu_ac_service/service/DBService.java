package service.fdu_ac_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.fdu_ac_service.dao.ACDaoImp;
import service.fdu_ac_service.model.Rule;

@Service("DBService")
public class DBService {
	@Autowired
	private ACDaoImp acDao;

	@Transactional
	public Rule[] getRuleList(long hash, int type) {
		Rule[] ruleList = acDao.getRuleList(hash, type);
		return ruleList;
	}

	@Transactional
	public long addRule(long hash, long[] tableIds, long userId, long catalog, int type) {
		long ret = acDao.addRule(hash, tableIds, userId, catalog, type);
		return ret;
	}

	@Transactional
	public long deleteRule(long rule_id) {
		return acDao.deleteRule(rule_id);
	}
}
