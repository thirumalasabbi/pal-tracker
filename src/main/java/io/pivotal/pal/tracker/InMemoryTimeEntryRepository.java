package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{


    private Map<Long,TimeEntry> _internalRepository = new HashMap<Long,TimeEntry>();
    private long index;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        index++;
        timeEntry.setId(index);
        _internalRepository.put(index,timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
       return  _internalRepository.get(id);

    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(_internalRepository.get(id)!=null) {
            timeEntry.setId(id);
            _internalRepository.put(id, timeEntry);
            return timeEntry;
        }else{
            return null;
        }

    }

    @Override
    public void delete(long id) {
        TimeEntry toDelete = _internalRepository.get(id);
        if(toDelete != null && toDelete.getId() == id) {
            _internalRepository.remove(id);
            //index--;
        }
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(_internalRepository.values());
        //List<TimeEntry> = asList( _internalRepository.values().toArray());
    }
}
