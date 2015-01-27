package edu.rutgers.model.api;

/**
 * API for data access. To be implemented by any DAO despite of the architecture.
 */
public interface ModelManager {
	
	/**
	 * Initial contact to DB system for health of connection and schema check.
	 * @throws Exception
	 */
	public void initializeManager() throws Exception;
}
