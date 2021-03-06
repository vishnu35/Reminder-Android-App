package birthday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import birthday.Contact;
import birthday.DateOfBirth;
import birthday.RawContact;

public class BirthContactHelper {

	public static List<BirthContact> createBirthContactList(List<Contact> contacts) {
		List<BirthContact> birthContacts = new ArrayList<BirthContact>();

		for (Contact contact : contacts) {
			Set<Calendar> dates = new LinkedHashSet<Calendar>();

			for (RawContact rawContact : contact.getRawContacts()) {
				for (DateOfBirth dateOfBirth : rawContact.getDatesOfBirth()) {
					if (!dates.contains(dateOfBirth.getDate())) {
						birthContacts.add(new BirthContact(contact, dateOfBirth));
						dates.add(dateOfBirth.getDate());
					}
				}
			}

			if (dates.isEmpty()) {
				birthContacts.add(new BirthContact(contact, null));
			}
		}

		return birthContacts;
	}
}
