data class UserProfile(
    val name: String,
    val username: String,
    val occupation: String,
    val profileImageResourceId: Int,
    val favorites: List<String>
)