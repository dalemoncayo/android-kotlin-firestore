# Android Firebase Firestore API Demo

This Android Kotlin project demonstrates simple API calls using Firebase Firestore to perform CRUD operations on posts. The project includes implementations for the following Firestore operations:

- Get a list of posts
- Get a post by its ID
- Create a new post

## Prerequisites

Before running the project, make sure you have the following set up:

- Android Studio installed
- Internet permission added to your AndroidManifest.xml file

## Firestore Operations

Instead of using Retrofit, this project utilizes Firebase Firestore to interact with the backend. The Firestore database schema includes the following collections:

- **Posts Collection:** `/post`
    - Documents within this collection represent posts.

## Libraries Used

- Firebase Firestore: [Link to Firestore Documentation](https://firebase.google.com/docs/firestore)
- RecyclerView: [android-kotlin-recyclerview](https://github.com/dalemncy/android-kotlin-recyclerview)

## Firestore Operations

- **Get Post List:** `/post`
  Example output: JSON array of post objects.

- **Get Post by ID:** `/post/{id}`
  Example output: JSON object representing a specific post.

- **Create Post:** `/post`
  Example input: JSON object representing a new post.

## Usage

1. Clone the repository from [GitHub](https://github.com/dalemncy/android-kotlin-firestore).

2. Open the project in Android Studio.

3. Run the app on an emulator or physical device.

4. Explore the code in the following activities:
    - `ListActivity`: Displays a list of posts.
    - `CreatePostActivity`: Allows the user to create a new post.
    - `PostActivity`: Displays details of a specific post.

## Additional Notes

- This is a simple demonstration project and may not cover all edge cases or best practices for a production application.
- The project also makes use of RecyclerViews. For more details on RecyclerView implementation, refer to [android-kotlin-recyclerview](https://github.com/dalemncy/android-kotlin-recyclerview).

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
