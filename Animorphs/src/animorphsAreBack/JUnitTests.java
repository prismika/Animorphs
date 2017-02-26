package animorphsAreBack;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTests {
	@Test
	public void t1(){
		TicTacToeriginal t = new TicTacToeriginal(3);
		System.out.println(t.toString());
	}
	@Test
	public void t2(){
		TicTacToeriginal t = new TicTacToeriginal(3);
		t.move(0, 0, 1);
		System.out.println(t.toString());
	}
	@Test
	public void t3(){
		TicTacToeriginal t = new TicTacToeriginal(3);
		t.move(0, 0, 1);
		assertTrue(t.winner() == 0);
	}
	@Test
	public void t4(){
		TicTacToeriginal t = new TicTacToeriginal(3);
		t.move(0, 0, 1);
		t.move(0, 1, 1);
		t.move(1, 0, 1);
		t.move(0, 2, 2);
		assertTrue(t.winner() == 0);
	}
	@Test
	public void t5(){
		TicTacToeriginal t = new TicTacToeriginal(3);
		t.move(0, 0, 1);
		t.move(1, 0, 1);
		t.move(2, 0, 1);
		assertTrue(t.winner() == 1);
	}
	@Test
	public void t6(){
		TicTacToeriginal t = new TicTacToeriginal(3);
		t.move(0, 0, 2);
		t.move(1, 0, 2);
		t.move(2, 0, 2);
		assertTrue(t.winner() == 2);
	}
	@Test
	public void t7(){
		TicTacToeriginal t = new TicTacToeriginal(3);
		t.move(0, 0, 1);
		t.move(1, 0, 2);
		t.move(2, 0, 1);
		
		t.move(0, 1, 1);
		t.move(1, 1, 2);
		t.move(2, 1, 1);

		t.move(0, 2, 2);
		t.move(1, 2, 1);
		t.move(2, 2, 2);
		
		System.out.println(t.toString());
		
		assertTrue(t.winner() == -1);
	}
	@Test
	public void t8(){
		TicTacToeriginal t = new TicTacToeriginal(3);
		t.move(0, 0, 1);
		t.move(1, 0, 2);
		t.move(2, 0, 2);
		
		t.move(0, 1, 1);
		t.move(1, 1, 2);
		t.move(2, 1, 1);

		t.move(0, 2, 2);
		t.move(1, 2, 1);
		t.move(2, 2, 2);
		
		System.out.println(t.toString());
		
		assertTrue(t.winner() == 2);
	}
	
	@Test
	public void t9(){
		CandidateAlgorithm pro = new CandidateAlgorithm(1);
		System.out.println(pro.treeToString());
	}
}
