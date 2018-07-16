package pack;

import javax.persistence.*;

@Entity
public class Account {
	private String description;
	private AccountPk id;

	public Account(String description) {
		this.description = description;
	}

	protected Account() {
	}

	@Id
	public AccountPk getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setId(AccountPk id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Embeddable
	public static class AccountPk {
		private String code;
		private Integer number;

		public AccountPk() {
		}

		public String getCode() {
			return this.code;
		}

		public Integer getNumber() {
			return this.number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public int hashCode() {
			int hashCode = 0;
			if (code != null)
				hashCode ^= code.hashCode();
			if (number != null)
				hashCode ^= number.hashCode();
			return hashCode;
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof AccountPk))
				return false;
			AccountPk target = (AccountPk) obj;
			return ((this.code == null) ? (target.code == null) : this.code
					.equals(target.code))
					&& ((this.number == null) ? (target.number == null)
							: this.number.equals(target.number));
		}
	}
}