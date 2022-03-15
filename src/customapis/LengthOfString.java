package customapis;


import java.util.logging.Logger;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="Length Of String"
        , summary=""
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class LengthOfString {
    
    @TestApiParameter(seq=1, 
            summary=" this is InputString",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String InputString;
    
   

    @TestApiParameter(seq=10, 
            summary="The length of string is :",
            remarks="",
            mandatory=true,
            parameterGroup="result")
    public String lengthOfString;

    @TestApiParameter(seq=11, 
            summary="The lifespan of the result.",
            remarks="",
            mandatory=true,
            parameterGroup="result",
            defaultValue="Test")
    public ValueScope resultScope;

    /** 
     * Used to write to the test execution log.
     */
    @TestLogger
    public Logger testLogger;
    
    /** 
     * Provides access to facilities, mainly to set and get variable values.
     */
    @TestExecutionContext
    public ITestExecutionContext testExecutionContext;
    
    @TestApiExecutor
    public void execute() {
    	
    	int los = InputString.length();
    	
    	
        testExecutionContext.setValue(lengthOfString, los, resultScope);
        
    }
    
}
