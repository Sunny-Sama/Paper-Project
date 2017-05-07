package service.fdu_ac_service.dao;

import service.fdu_ac_service.model.Rule;

public interface ACDao {
	public Rule[] getRuleList(long hash, int type);
	public long addRule(long hash, long[] tableIds, long userId, long catalog, int type);
	public long deleteRule(long rule_id);
}
