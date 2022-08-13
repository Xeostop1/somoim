package beans;

import java.util.*;

public class Notice {

		private int number;
		private String title;
		private String nickname;
		private Date writingtime; 
		private String content;

//=========»ý¼ºÀÚ==============
		public Notice() {
		}
		public Notice(int number, String title, String nickname, Date writingtime, String content) {
			this.number = number;
			this.title = title;
			this.nickname = nickname;
			this.writingtime = writingtime;
			this.content = content;
		}
//===============geter Seter=============
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public Date getWritingtime() {
			return writingtime;
		}
		public void setWritingtime(Date writingtime) {
			this.writingtime = writingtime;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
//==========toString================
		public String toString() {
			return "Notice [number=" + number + ", title=" + title + ", nickname=" + nickname + ", writingtime="
					+ writingtime + ", content=" + content + "]";
		}
}
