import org.junit.Before;
import org.junit.Test;

import org.academiadecodigo.bootcamp.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Test1 {
	private int nrRows = 10;
	private int nrCols = 10;
	private String[][] gridColor = new String[nrRows][nrCols];

	@Before
	public void setup() {
for(int i=0; i<nrRows;i++) {
	for(int j = 0; j< nrCols; j++) {
		gridColor[i][j] = "" + i + j;
	}
}
	}
	
	@Test
	public void testSave2() {
		Save save = new Save();
		String[][] testGrid = save.save(gridColor, nrRows, nrCols);
		assertEquals(testGrid[1][2], gridColor[1][2]);
	}
}
