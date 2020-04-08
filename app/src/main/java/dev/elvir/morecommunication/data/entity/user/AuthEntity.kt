package dev.elvir.morecommunication.data.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Entity
data class AuthEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @TypeConverters(AuthStateConverter::class)
    var authState: AuthState = AuthState.NOT_ACTIVATED
)

enum class AuthState(state: Int) {
    ACTIVATED(0), NOT_ACTIVATED(1)
}

class AuthStateConverter() {

    @TypeConverter
    fun fromAuthState(value: AuthState): Int = value.ordinal

    @TypeConverter
    fun toAuthState(value: Int): AuthState {
        return when (value) {
            0 -> AuthState.ACTIVATED
            1 -> AuthState.NOT_ACTIVATED
            else -> AuthState.NOT_ACTIVATED
        }
    }

}