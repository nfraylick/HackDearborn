
class TranslationActivity : AppCompatActivity() {

    private lateinit var correctTranslation: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translation)

        buttonTranslate.setOnClickListener {
            val arabicPhrase = editTextArabicPhrase.text.toString()
            if (arabicPhrase.isNotEmpty()) {
                translateToEnglish(arabicPhrase)
            }
        }
    }

    private fun translateToEnglish(arabicPhrase: String) {
        // Same translation logic as before...

        // Assume 'result' contains the translated text
        correctTranslation = result

        // Generate random wrong options (you can customize the logic for wrong options)
        val wrongOption1 = "Wrong Option 1"
        val wrongOption2 = "Wrong Option 2"
        val wrongOption2 = "Wrong Option 3"

        // Display correct and wrong options randomly
        val options = mutableListOf(correctTranslation, wrongOption1, wrongOption2).shuffled()

        // Set text for buttons
        buttonOption1.text = options[0]
        buttonOption2.text = options[1]

        // Set click listeners for options
        buttonOption1.setOnClickListener { checkAnswer(buttonOption1.text.toString()) }
        buttonOption2.setOnClickListener { checkAnswer(buttonOption2.text.toString()) }
    }

    private fun checkAnswer(selectedOption: String) {
        val feedbackMessage = if (selectedOption == correctTranslation) {
            "Correct! Well done!"
        } else {
            "Incorrect. Try again!"
        }
        textViewTranslation.text = feedbackMessage

        // Optionally, you can reset the game or navigate to another screen after answering
    }
}
