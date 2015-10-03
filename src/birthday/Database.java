package birthday;

import java.util.Calendar;
import java.util.List;

import android.content.ContentResolver;
import birthday.ContactDataAccess;
import birthday.DateOfBirthDataAccess;
import birthday.Contact;
import birthday.DateOfBirth;
import birthday.RawContact;

public class Database {

	private final ContactDataAccess contactDataAccess;
	private final DateOfBirthDataAccess dateOfBirthDataAccess;

	public Database(ContentResolver contentResolver) {
		this.contactDataAccess = new ContactDataAccess(contentResolver);
		this.dateOfBirthDataAccess = new DateOfBirthDataAccess(contentResolver);
	}

	public List<Contact> getAllContacts() {
		return this.contactDataAccess.getAll();
	}

	public Contact getContact(int contactId) {
		return this.contactDataAccess.get(contactId);
	}

	public void createDateOfBirth(RawContact rawContact, Calendar date) {
		this.dateOfBirthDataAccess.create(rawContact, date);
	}

	public void updateDateOfBirth(DateOfBirth dateOfBirth, Calendar newDate) {
		this.dateOfBirthDataAccess.update(dateOfBirth, newDate);
	}

	public void deleteDateOfBirth(DateOfBirth dateOfBirth) {
		this.dateOfBirthDataAccess.delete(dateOfBirth);
	}
}
