package bananaGEST;

import static org.junit.Assert.*;
import com.generation.jwd.p1.beans.*;

import org.junit.Test;

public class LoginBeanTest {
	
	LoginBean usuario = new LoginBean();
//	UserBean b1 = new UserBean("borja","11111");
//	boolean admin = usuario.validator();
	UserBean Mario = new UserBean(
			"muvalera",
			"12345"
			);
	
	UserBean Claudia = new UserBean(
			"claudiamas",
			"56789"
			);
	
	UserBean Daniel = new UserBean(
			"danilozano",
			"01010"
			);
	
	UserBean Borja = new UserBean(
			"borjaherranz",
			"11111"
			);
	
	UserBean Enrique = new UserBean(
			"enriqueruiz",
			"99999"
			);
	
	UserBean[] users = {Mario, Claudia, Daniel, Borja, Enrique};

	@Test
	public void testValidatorWithEmailBorjaReturnCorrectData() {
		LoginBean borja = new LoginBean();
//		Boolean resultadoreal = borja.validator("borjaherranz", "11111");
//		Boolean resultadoesperado = true;
//		assertTrue(borja.validator("borjaherranz", "11111"));
	}
	
	
}


	
