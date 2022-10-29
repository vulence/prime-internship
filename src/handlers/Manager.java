package handlers;

import common.Type;

public class Manager extends Approver {
    @Override
    public void approve(int id, double cost, Type type) {
    	if (canApprove(cost, type)) {
            System.out.println("Manager approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Manager.");
        next.approve(id, cost, type);
    }

    @Override
    protected boolean canApprove(double cost, Type type) {
    	if (cost > 5000) return false;
    	
    	switch (type) {
    	case CONSUMABLES:
    		return cost <= 300 ? true : false;
    	case CLERICAL:
    		return cost <= 500 ? true : false;
    	case GADGETS:
    		return cost <= 1000 ? true : false;
    	case GAMING:
    		return cost <= 3000 ? true : false;
    	case PC:
    		return cost <= 5000 ? true : false;
    	default:
    		return false;
    	}
    }
}
