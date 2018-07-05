package webservice.examples;

import javax.jws.WebService;

@WebService(targetNamespace = "http://www.example.org/kalkulator/",
	serviceName = "kalkulator",
	portName = "kalkulatorSOAP",
	endpointInterface = "webservice.examples.Kalkulator",
	wsdlLocation = "WEB-INF/wsdl/Kalkulator.wsdl")
public class KalkulatorImpl implements Kalkulator {
	public int add(int arg1, int arg2) {
		return arg1 + arg2;
	}

	public int sub(int arg1, int arg2) {
		return arg1 - arg2;
	}

	public int mul(int arg1, int arg2) {
		return arg1 * arg2;
	}

	public void div(int arg1, int arg2,
			javax.xml.ws.Holder<Integer> quotient,
			javax.xml.ws.Holder<Integer> remainder) {
		
		quotient.value = arg1 / arg2;
		remainder.value = arg1 % arg2;
	}

}