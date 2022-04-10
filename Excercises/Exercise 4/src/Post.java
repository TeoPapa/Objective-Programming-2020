import java.util.Date;

public class Post {

		private Date timestap;
		private String text;
		private User pUser;
		
		public Post(Date t, String txt, User u) {
			timestap = t;
			text = txt;
			pUser = u;
		}
		
		
		public Date getTime() {
			return timestap;
		}
		
		public String getPText() {
			return text;
		}
		
		public User getPUser() {
			return pUser;
		}
		
		public String getThePost() {
			return (pUser.getUsername() + ", " + timestap + ", " + text);
		}
}
