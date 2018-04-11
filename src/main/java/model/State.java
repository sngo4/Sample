package model;

public enum State {
	NEW{
		public String toString() {
			return "NEW";
		}
	}, ACTIVE{
		public String toString() {
			return "ACTIVE";
		}
	}, DISABLE{
		public String toString() {
			return "DISABLE";
		}
	}, REMOVABLE{
		public String toString() {
			return "REMOVABLE";
		}
	};
	public abstract String toString();
}