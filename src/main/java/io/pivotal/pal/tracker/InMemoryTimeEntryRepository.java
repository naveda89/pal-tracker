package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Long start_id= 0L;
    private Map<Long,TimeEntry> timeEntries = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntry) {
        start_id += 1;
        timeEntry.setId(start_id);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        timeEntries.put(id, timeEntry);
        return timeEntry;
    }

    public TimeEntry delete(long id) {
        return timeEntries.remove(id);
    }
}
