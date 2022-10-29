package handlers;

import common.Type;

public class VicePresident extends Approver{
    @Override
    public void approve(int id, double cost, Type type) {
    	if (canApprove(cost, type)) {
    		System.out.println("Vice President approved purchase with id " + id + " that costs " + cost);
            return;
    	}
    	
    	System.out.println("Purchase with id " + id + " needs approval from higher position than Vice President.");
    	next.approve(id, cost, type);
    }

    @Override
    protected boolean canApprove(double cost, Type type) {
    	if (cost > 6500) return false;
    	
    	switch (type) {
    	case CONSUMABLES:
    		return cost <= 700 ? true : false;
    	case CLERICAL:
    		return cost <= 1500 ? true : false;
    	case GADGETS:
    		return cost <= 2000 ? true : false;
    	case GAMING:
    		return cost <= 4500 ? true : false;
    	case PC:
    		return cost <= 6500 ? true : false;
    	default:
    		return false;
    	}
    }
}
