import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UpcomingEventsActivity extends AppCompatActivity {

    private ListView eventsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_events);

        // Initialize UI elements
        eventsListView = findViewById(R.id.eventsListView);

        // Sample data for upcoming events
        String[] events = {
            "Event 1 - November 12, 2023",
            "Event 2 - December 5, 2023",
            "Event 3 - December 15, 2023",
            // Add more event strings as needed
        };

        // Create an ArrayAdapter to populate the ListView with event data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, events);

        // Set the adapter for the ListView
        eventsListView.setAdapter(adapter);
    }
}

