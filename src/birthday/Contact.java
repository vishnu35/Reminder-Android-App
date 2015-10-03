package birthday;

import java.util.List;

public interface Contact {

	public int getId();

	public String getName();

	public List<RawContact> getRawContacts();
}