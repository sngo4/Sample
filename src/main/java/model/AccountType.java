package model;

public enum AccountType {
	DEPOSIT{
		public String toString() {
			return "DEPOSIT";
		}
	},SAVING{
		public String toString() {
			return "SAVING";
		}
	},OTHER{
		public String toString() {
			return "OTHER";
		}
	};
	public abstract String toString();
}
