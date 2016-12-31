package infrastructure.tracking;

import java.util.List;

/**
 * Created by bruenni on 29.12.16.
 */
public class Track {
    private String name;
    private String desc;
    private Iterable<TrackPoint> points;

    public Track(String name, String desc, Iterable<TrackPoint> points) {
        this.name = name;
        this.desc = desc;
        this.points = points;
    }

    public Iterable<TrackPoint> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Track{" +
                "points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (!points.equals(track.points)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return points.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
