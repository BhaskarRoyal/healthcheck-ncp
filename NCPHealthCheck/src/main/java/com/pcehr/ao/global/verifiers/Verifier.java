/**
 * 
 */
package com.pcehr.ao.global.verifiers;

import com.pcehr.ao.global.exception.HealthCheckException;
import com.pcehr.base.utils.CustomException;

/**
 * @author bhaskara.vallapu
 *
 */
public interface Verifier {
	public boolean verify(String action) throws HealthCheckException, CustomException, Exception;

}
