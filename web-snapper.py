
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from pymongo import MongoClient
import base64

# MongoDB connection
client = MongoClient('mongodb://username:password@localhost:27017/')  # Replace with your MongoDB connection URI
db = client['webpage_screenshots']
collection = db['screenshots']

# Function to take a screenshot of a webpage and store it in MongoDB
def take_screenshot(url):
    chrome_options = Options()
    chrome_options.add_argument("--headless")  # Run Chrome in headless mode (no GUI)

    driver = webdriver.Chrome(chrome_options=chrome_options)
    driver.get(url)

    # Wait for the page to load (you might need to adjust the sleep duration)
    driver.implicitly_wait(10)

    # Take a screenshot
    screenshot = driver.get_screenshot_as_png()

    # Convert the screenshot to base64 for storing in MongoDB
    encoded_screenshot = base64.b64encode(screenshot).decode('utf-8')

    # Store the URL and screenshot in MongoDB
    collection.insert_one({'url': url, 'screenshot': encoded_screenshot})

    driver.quit()

# Example usage
if __name__ == "__main__":
    url = url
    take_screenshot(url)
    print("Screenshot captured and stored in MongoDB.")

