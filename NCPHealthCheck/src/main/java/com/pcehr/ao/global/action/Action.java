package com.pcehr.ao.global.action;

import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.base.utils.CustomException;

public interface Action {

	public boolean performAction(String action) throws HealthCheckException, CustomException, Exception;
	
}
