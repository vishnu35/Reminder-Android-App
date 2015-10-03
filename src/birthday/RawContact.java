package birthday;

import java.util.List;

public interface RawContact {

	public int getId();

	public Contact getContact();

	public String getAccountType();

	public String getAccountName();

	public List<DateOfBirth> getDatesOfBirth();
}