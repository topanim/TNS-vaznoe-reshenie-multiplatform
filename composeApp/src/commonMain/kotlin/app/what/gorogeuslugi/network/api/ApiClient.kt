package app.what.gorogeuslugi.network.api

import app.what.gorogeuslugi.data.AppSettings
import app.what.gorogeuslugi.features.voting.domain.models.Answer
import app.what.gorogeuslugi.foundation.core.Monitor.Companion.monitored
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class ApiClient(
    private val client: HttpClient
) {
    private companion object {
        const val BASE_URL = "http://45.155.207.232:1478"

        inline fun <reified T> addBody(data: T): HttpRequestBuilder.() -> Unit = {
            contentType(ContentType.Application.Json)
            setBody(data)
        }

        inline fun <reified T : Api.AuthRequest> addBodyWithAuth(
            data: T
        ): HttpRequestBuilder.() -> Unit = {
            parameter("token", data.token)
            contentType(ContentType.Application.Json)
            setBody(data)
        }

        inline fun addBodyWithAuth2(
            data: String
        ): HttpRequestBuilder.() -> Unit = {
            parameter("token", data.toString())
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun esiaLogin(request: Api.Esia.Login.Request): Api.Esia.Login.Response =
        client.post("$BASE_URL/esia/login", addBody(request)).body()

    suspend fun esiaUserInfo(request: Api.Esia.UserInfo.Request): Api.Esia.UserInfo.Response =
        client.get("$BASE_URL/esia/user_info", addBody(request)).body()

    // ---

    suspend fun authRegister(request: Api.Auth.Register.Request): Api.Auth.Register.Response =
        client.post("$BASE_URL/auth/register", addBody(request)).body()

    suspend fun authLogin(request: Api.Auth.Login.Request): Api.Auth.Login.Response =
        client.post("$BASE_URL/auth/login/", addBody(request)).body()

    // ---

    suspend fun rolesGetAll(request: Api.Roles.GetAll.Request): List<Api.Roles.GetAll.Response.Role> =
        client.get("$BASE_URL/roles", addBodyWithAuth(request)).body()

    suspend fun rolesGetOne(request: Api.Roles.GetOne.Request): Api.Roles.GetOne.Response =
        client.get("$BASE_URL/roles/${request.id}", addBodyWithAuth(request)).body()

    suspend fun rolesCreate(request: Api.Roles.Create.Request): Api.Roles.Create.Response =
        client.post("$BASE_URL/roles/", addBodyWithAuth(request)).body()

    suspend fun rolesUpdate(request: Api.Roles.Update.Request): Api.Roles.Update.Response =
        client.put("$BASE_URL/roles/${request.id}", addBodyWithAuth(request)).body()

    suspend fun rolesDelete(request: Api.Roles.Delete.Request) =
        client.delete("$BASE_URL/roles/${request.id}", addBodyWithAuth(request))

    // ---

    suspend fun usersGetAll(request: Api.Users.GetAll.Request): List<Api.Users.GetAll.Response.User> =
        client.get("$BASE_URL/users", addBodyWithAuth(request)).body()

    suspend fun usersGetOne(request: Api.Users.GetOne.Request): Api.Users.GetOne.Response =
        client.get("$BASE_URL/users/${request.id}", addBodyWithAuth(request)).body()

    suspend fun usersCreate(request: Api.Users.Create.Request): Api.Users.Create.Response =
        client.post("$BASE_URL/users/", addBodyWithAuth(request)).body()

    suspend fun usersUpdate(request: Api.Users.Update.Request): Api.Users.Update.Response =
        client.put("$BASE_URL/users/${request.id}", addBodyWithAuth(request)).body()

    suspend fun usersDelete(request: Api.Users.Delete.Request): Api.Users.Delete =
        client.delete("$BASE_URL/users/${request.id}", addBodyWithAuth(request)).body()

    suspend fun userMe(request: String): Api.Users.Me.Response =
        client.get("$BASE_URL/users/user/me", addBodyWithAuth2(request)).body()

    // ---

    suspend fun meetingsGetAll(request: Api.Meetings.GetAll.Request): List<Api.Meetings.GetAll.Response.Meeting> =
        client.get("$BASE_URL/meetings", addBodyWithAuth(request)).body()

    suspend fun meetingsGetOne(request: Api.Meetings.GetOne.Request): Api.Meetings.GetOne.Response =
        client.get("$BASE_URL/meetings/${request.id}", addBodyWithAuth(request)).body()

    suspend fun meetingsCreate(request: Api.Meetings.Create.Request): Api.Meetings.Create.Response =
        client.post("$BASE_URL/meetings/", addBodyWithAuth(request)).body()

    suspend fun meetingsUpdate(request: Api.Meetings.Update.Request): Api.Meetings.Update.Response =
        client.put("$BASE_URL/meetings/${request.id}", addBodyWithAuth(request)).body()

    suspend fun meetingsDelete(request: Api.Meetings.Delete.Request) =
        client.delete("$BASE_URL/meetings/${request.id}", addBodyWithAuth(request))

    suspend fun meetingsSendDoc(request: Api.Meetings.SendDoc.Request): String =
        client.post("$BASE_URL/meetings/${request.id}/send_doc", addBodyWithAuth(request))
            .bodyAsText()

    // ---

    suspend fun questionsGetAll(request: Api.Questions.GetAll.Request): List<Api.Questions.GetAll.Response.Question> =
        client.get("$BASE_URL/question", addBodyWithAuth(request)).body()

    suspend fun questionsGetAllByMeeting(request: Api.Questions.GetAllByMeeting.Request): List<Api.Questions.GetAllByMeeting.Response.Question> {
        val rec = client.get(
            "$BASE_URL/question/meetings/${request.meeting_id}/questions",
            addBodyWithAuth(request)
        )
        try {
            return rec.body()
        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun questionsGetOne(request: Api.Questions.GetOne.Request): Api.Questions.GetOne.Response =
        client.get("$BASE_URL/question/${request.id}", addBodyWithAuth(request)).body()

    suspend fun questionsCreate(request: Api.Questions.Create.Request): Api.Questions.Create.Response =
        client.post("$BASE_URL/question/", addBodyWithAuth(request)).body()

    suspend fun questionsUpdate(request: Api.Questions.Update.Request): Api.Questions.Update.Response =
        client.put("$BASE_URL/question/${request.id}", addBodyWithAuth(request)).body()

    suspend fun questionsDelete(request: Api.Questions.Delete.Request) =
        client.delete("$BASE_URL/question/${request.id}", addBodyWithAuth(request))

    // ---

    suspend fun votesGetAll(request: Api.Votes.GetAll.Request): List<Api.Votes.GetAll.Response.Vote> =
        client.get("$BASE_URL/vote", addBodyWithAuth(request)).body()

    suspend fun votesGetOne(request: Api.Votes.GetOne.Request): Api.Votes.GetOne.Response =
        client.get("$BASE_URL/vote/${request.id}", addBodyWithAuth(request)).body()

    suspend fun votesCreate(request: Api.Votes.Create.Request): Api.Votes.Create.Response =
        client.post("$BASE_URL/vote/ ", addBodyWithAuth(request)).body()

    suspend fun votesUpdate(request: Api.Votes.Update.Request): Api.Votes.Update.Response =
        client.put("$BASE_URL/vote/${request.id}", addBodyWithAuth(request)).body()

    suspend fun votesDelete(request: Api.Votes.Delete.Request) =
        client.delete("$BASE_URL/vote/${request.id}", addBodyWithAuth(request))
}

object Api {
    abstract class AuthRequest {
        val token: String = AppSettings.getToken()
    }

    object Esia {
        object Login {
            @Serializable
            data class Request(
                val username: String,
                val password: String,
                @SerialName("totp_str") val totpStr: String
            )

            @Serializable
            data class Response(
                val action: String,
                @SerialName("mfa_details") val mfaDetails: MfaDetails,
                @SerialName("jwt_token") val jwtToken: String
            ) {
                @Serializable
                data class MfaDetails(
                    @SerialName("ttp_details") val ttpDetails: TtpDetails,
                    val type: String
                )

                @Serializable
                data class TtpDetails(
                    @SerialName("code_length") val codeLength: Int
                )
            }
        }

        object UserInfo {
            @Serializable
            data class Request(
                @SerialName("jwt_token") val jwtToken: String
            )

            @Serializable
            data class Response(
                val lastName: String,
                val isAssuranceLevelCorrect: String,
                val gender: String,
                val personEMail: String,
                val personSNILS: String,
                val authToken: String,
                val formattedName: String,
                val rf_passport_vrf_stu: String,
                val personCitizenship: String,
                val mobileVerified: Boolean,
                val assuranceLevel: String,
                val principalDocuments: String,
                val personMobilePhone: String,
                val personINN: String,
                val personVerifying: Boolean,
                val mdcl_plcy_vrf_stu_val: Boolean,
                val formattedLoginName: String,
                val personType: String,
                val email: String,
                val kids: List<String>,
                val liveAddress: String,
                val inn: String,
                val mobile: String,
                val personDocTypes: String,
                val registrationAddress: String,
                val userName: String,
                val userId: Int,
                val birthDate: String,
                val firstName: String,
                val emailVerified: Boolean,
                val globalRole: String,
                val person: Person,
            ) {
                @Serializable
                data class Person(
                    val error: String,
                    val id: String,
                    val person: AdditionalProp1? = null,
                    val orgs: List<String>,
                    val docs: List<AdditionalProp1>,
                    val addresses: List<PersonAddress>,
                    val contacts: List<Contact>,
                    val vehicles: List<String>,
                    val kids: List<String>,
                    val registration: AdditionalProp1,
                    val roles: List<String>,
                    val biometrics: List<String>,
                    val totalVehicles: Int,
                    val socials: List<String>
                )

                @Serializable
                data class AdditionalProp1(
                    val additionalProp1: String
                )

                @Serializable
                data class Contact(
                    val id: String,
                    val type: String,
                    val vrfStu: String,
                    val value: String,
                    val etag: String,
                )

                @Serializable
                data class PersonAddress(
                    val id: String,
                    val type: String,
                    val addressStr: String,
                    val countryId: String,
                    val fiasCode: String,
                    val house: String,
                    val region: String,
                    val street: String,
                    val zipCode: String,
                    val flat: String? = null,
                    val city: String,
                    val area: String,
                    val esiaAddressSrt: String,
                    val verifiedOn: Int? = null,
                    val fullAddress: String,
                    val etag: String,
                )
            }
        }
    }

    object Auth {
        object Register {
            @Serializable
            data class Request(
                val login: String,
                val password: String,
                val role_id: Int
            )

            @Serializable
            class Response
        }

        object Login {
            @Serializable
            data class Request(
                val login: String,
                val password: String
            )

            @Serializable
            class Response(
                val access_token: String,
                val token_type: String
            )
        }
    }

    object Roles {
        object GetAll {
            @Serializable
            class Request : AuthRequest()

            @Serializable
            object Response {
                data class Role(
                    val id: Int,
                    val name: String
                )
            }
        }

        object GetOne {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            data class Response(
                val name: String
            )
        }

        object Create {
            @Serializable
            data class Request(
                val name: String
            ) : AuthRequest()

            @Serializable
            data class Response(
                val id: Int,
                val name: String
            )
        }

        object Update {
            @Serializable
            data class Request(
                val id: Int,
                val name: String
            ) : AuthRequest()

            @Serializable
            data class Response(
                val name: String
            )
        }

        object Delete {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            class Response
        }
    }

    object Users {
        object GetAll {
            @Serializable
            class Request : AuthRequest()

            object Response {
                @Serializable
                data class User(
                    val login: String,
                    val role_id: Int,
                    val id: Int
                )
            }
        }

        object Me {
            @Serializable
            data class Request(
                val id: String
            ) : AuthRequest()

            @Serializable
            data class Response(
                val id: Int,
                val login: String,
                val position: String,
                val workplace: String,
                val address: String,
                val email: String,
                val phone: String,
                @SerialName("passport_series_number")
                val passportSeriesNumber: String,
                @SerialName("passport_data")
                val passportData: String,
                val name: String
            )
        }

        object GetOne {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            data class Response(
                val login: String,
                val role_id: Int
            )
        }

        object Create {
            @Serializable
            data class Request(
                val login: String,
                val role_id: Int
            ) : AuthRequest()

            @Serializable
            data class Response(
                val login: String,
                val role_id: Int
            )
        }

        object Update {
            @Serializable
            data class Request(
                val id: Int,
                val login: String,
                val role_id: Int
            ) : AuthRequest()

            @Serializable
            data class Response(
                val login: String,
                val role_id: Int
            )
        }

        object Delete {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            class Response
        }
    }

    object Meetings {
        object GetAll {
            @Serializable
            class Request : AuthRequest()

            object Response {
                @Serializable
                data class Meeting(
                    val id: Int,
                    val title: String,
                    val text: String,
                    val status: Boolean,
                    val meeting_link: String,
                    val role_id: Int,
                    val format: String,
                    val ai_comment: String?
                )
            }
        }

        object GetOne {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            data class Response(
                val id: Int,
                val title: String,
                val text: String,
                val status: Boolean,
                val format: String,
                val meeting_link: String,
                val role_id: Int,
                val ai_comment: String?
            ) {
                var comment by monitored("")
            }
        }

        object SendDoc {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()
        }

        object Create {
            @Serializable
            data class Request(
                val id: Int,
                val title: String,
                val text: String,
                val format: String,
                val status: Boolean,
                val meeting_link: String,
                val role_id: Int,
                val ai_comment: String?
            ) : AuthRequest()

            @Serializable
            data class Response(
                val id: Int,
                val title: String,
                val text: String,
                val status: Boolean,
                val meeting_link: String,
                val role_id: Int,
                val format: String,
                val ai_comment: String?
            )
        }

        object Update {
            @Serializable
            data class Request(
                val id: Int,
                val title: String,
                val text: String,
                val status: Boolean,
                val format: String,
                val meeting_link: String,
                val role_id: Int
            ) : AuthRequest()

            @Serializable
            data class Response(
                val id: Int,
                val title: String,
                val text: String,
                val status: Boolean,
                val format: String,
                val meeting_link: String,
                val role_id: Int,
                val ai_comment: String?
            )
        }

        object Delete {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            class Response
        }
    }

    object Questions {
        object GetAll {
            @Serializable
            class Request : AuthRequest()

            @Serializable
            object Response {
                data class Question(
                    val id: Int,
                    val meeting_id: Int,
                    val text: String
                )
            }
        }

        object GetAllByMeeting {
            @Serializable
            class Request(
                val meeting_id: Int
            ) : AuthRequest()

            object Response {
                @Serializable
                data class Question(
                    val id: Int?,
                    val meeting_id: Int,
                    val text: String
                ) {
                    var answer by monitored<Answer?>(null)
                }
            }
        }

        object GetOne {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            data class Response(
                val meeting_id: Int,
                val text: String
            )
        }

        object Create {
            @Serializable
            data class Request(
                val id: Int,
                val meeting_id: Int,
                val text: String
            ) : AuthRequest()

            @Serializable
            data class Response(
                val id: Int,
                val meeting_id: Int,
                val text: String
            )
        }

        object Update {
            @Serializable
            data class Request(
                val id: Int,
                val text: String
            ) : AuthRequest()

            @Serializable
            data class Response(
                val id: Int,
                val meeting_id: Int,
                val text: String
            )
        }

        object Delete {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            class Response
        }
    }

    object Votes {
        object GetAll {
            @Serializable
            class Request : AuthRequest()

            object Response {
                @Serializable
                data class Vote(
                    val user_id: Int,
                    val question_id: Int,
                    val choice: String
                )
            }
        }

        object GetOne {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            data class Response(
                val user_id: Int,
                val meeting_id: Int,
                val text: String
            )
        }

        object Create {
            @Serializable
            data class Request(
                val question_id: Int,
                val choice: String
            ) : AuthRequest()

            @Serializable
            data class Response(
                val user_id: Int,
                val question_id: Int,
                val choice: String
            )
        }

        object Update {
            @Serializable
            data class Request(
                val id: Int,
                val user_id: Int,
                val question_id: Int,
                val choice: String
            ) : AuthRequest()

            @Serializable
            data class Response(
                val user_id: Int,
                val question_id: Int,
                val choice: String
            )
        }

        object Delete {
            @Serializable
            data class Request(
                val id: Int
            ) : AuthRequest()

            @Serializable
            class Response
        }
    }
}