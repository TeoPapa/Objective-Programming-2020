public class Main {

	public static void main(String[] args) {
		/* (PamakBook 3 Note): The task asks to add to the functionality of the previous task. So I decided to let the
		 * methods that print, but remove the parts where they are printed. Also I remove some
		 * Syste.out.print cause they were printing inside a useful (for the current task) method.
		 * I tried to keep the previous functionality while also adding more to it.
		 */
		
		PamakBook.loadFiles();
		
		PamakBook.addGroup( new Group("WebGurus","A group for web passionates") );
		PamakBook.addGroup( new ClosedGroup("ExamSolutions","Solutions to common exam questions") );
		
		
		
		new PamakBookGUI();
	}

}
