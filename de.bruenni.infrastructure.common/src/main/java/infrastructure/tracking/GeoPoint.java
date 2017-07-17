package infrastructure.tracking;

/**
 * Created by bruenni on 16.01.17.
 */
public class GeoPoint<T> {
	private final T latitude;
	private final T longitude;

	/**
	 * Constructor
	 * @param latitude
	 * @param longitude
	 */
	public GeoPoint(T latitude, T longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return String.format("[lat=%1s, long=%2s]", getLatitude(), getLongitude());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GeoPoint geoPoint = (GeoPoint) o;

		if (!latitude.equals(geoPoint.latitude)) return false;
		return longitude.equals(geoPoint.longitude);
	}

	@Override
	public int hashCode() {
		int result = latitude.hashCode();
		result = 31 * result + longitude.hashCode();
		return result;
	}

	public T getLatitude() {
		return latitude;
	}

	public T getLongitude() {
		return longitude;
	}
}
