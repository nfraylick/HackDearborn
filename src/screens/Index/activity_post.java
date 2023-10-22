public class PostActivity extends AppCompatActivity {

    private EditText editTextPost;
    private Button buttonPost;
    private RecyclerView recyclerViewPosts;

    private List<Post> postList;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        editTextPost = findViewById(R.id.editTextPost);
        buttonPost = findViewById(R.id.buttonPost);
        recyclerViewPosts = findViewById(R.id.recyclerViewPosts);

        // Initialize postList and postAdapter (using Firebase Firestore or any backend service)

        // Setup RecyclerView
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter(postList);
        recyclerViewPosts.setAdapter(postAdapter);

        // Handle Post Button Click
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postText = editTextPost.getText().toString().trim();
                if (!postText.isEmpty()) {
                    // Add the post to the backend service (Firebase Firestore, etc.)
                    // Clear the editTextPost after posting
                    editTextPost.setText("");
                }
            }
        });
    }
}

