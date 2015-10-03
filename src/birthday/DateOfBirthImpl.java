package birthday;

import java.util.Calendar;

import birthday.DateOfBirth;
import birthday.RawContact;

public class DateOfBirthImpl implements DateOfBirth {

	protected final int id;
	private final RawContact rawContact;
	private final Calendar date;

	protected DateOfBirthImpl(int id, RawContact rawContact, Calendar date) {
		super();

		this.id = id;
		this.rawContact = rawContact;
		this.date = date;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public RawContact getRawContact() {
		return rawContact;
	}

	@Override
	public Calendar getDate() {
		return date;
	}
}
