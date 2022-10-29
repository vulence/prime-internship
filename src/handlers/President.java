package handlers;

import common.Type;

public class President extends Approver{
    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(cost, type)) {
        	System.out.println("President approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than President.");
        next.approve(id, cost, type);
    }

    @Override
    protected boolean canApprove(double cost, Type type) {
    	if (cost > 8000) return false;
    	
    	switch (type) {
    	case CONSUMABLES:
    		return cost <= 1000 ? true : false;
    	case CLERICAL:
    		return cost <= 2000 ? true : false;
    	case GADGETS:
    		return cost <= 3000 ? true : false;
    	case GAMING:
    		return cost <= 5000 ? true : false;
    	case PC:
    		return cost <= 8000 ? true : false;
    	default:
    		return false;
    	}
    }
}
