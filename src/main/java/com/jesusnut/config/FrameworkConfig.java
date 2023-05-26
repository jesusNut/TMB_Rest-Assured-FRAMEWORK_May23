package com.jesusnut.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ "system:properties", "system:env", "file:${user.dir}/src/test/resources/config/FrameworkConfig.properties"})
 interface FrameworkConfig extends Config {

	
	@Key("baseURL")
	String baseURL();
	
	@DefaultValue("true")
	@Key("customizedReport")
	boolean customizedReport();
	
	@DefaultValue("true")
	@Key("overrideReports")
	boolean overrideReports();

}
