package com.camtrack.tracker.retrofit;


import com.camtrack.tracker.activities.stealthactivities.StealthFaceRequestModel;
import com.camtrack.tracker.activities.stealthactivities.StealthRequestModel;
import com.camtrack.tracker.models.AddDriverImageRequestBody;
import com.camtrack.tracker.models.AllDevicesSettingResponse;
import com.camtrack.tracker.models.DeviceInformation;
import com.camtrack.tracker.models.GeocoderAddressBean;
import com.camtrack.tracker.models.HotSpotUser;
import com.camtrack.tracker.models.OrderDetails;
import com.camtrack.tracker.models.PubNubKeysBean;
import com.camtrack.tracker.models.SignInSignUpResponse;
import com.camtrack.tracker.models.SignUpModel;
import com.camtrack.tracker.models.SocialApiSignUpModel;
import com.camtrack.tracker.models.TripData2Share;
import com.camtrack.tracker.models.TripMediaResponse;
import com.camtrack.tracker.models.UpdateUser;
import com.camtrack.tracker.models.device.AddDeviceModelResponse;
import com.camtrack.tracker.models.device.DeviceInfo;
import com.camtrack.tracker.models.device.TrackerDeviceBean;
import com.camtrack.tracker.models.device.sharedusers.SharedUser;
import com.camtrack.tracker.models.diagnostic.DiagnosticCheckResponse;
import com.camtrack.tracker.models.librarycreatedvideo.CreatedVideo;
import com.camtrack.tracker.models.mapdirection.Directions;
import com.camtrack.tracker.models.settingsmodel.DefaultSettings;
import com.google.gson.annotations.Expose;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })
    @GET("/devices")
    Call<SignInSignUpResponse> sendOTP(@Body SignUpModel dataObject);

    @POST("/devices/register")
    Call<SignInSignUpResponse> signInWithTracker(@Body SignUpModel dataObject);

    @POST("/facebook")
    Call<SignInSignUpResponse> signUpFacebookWithTracker(@Body SocialApiSignUpModel dataObject);


    @POST("/google")
    Call<SignInSignUpResponse> signUpGoogleWithTracker(@Body SocialApiSignUpModel dataObject);

    @GET
    Call<Directions> getWalkingDirections(@Url String url);

    @GET
    Call<DeviceInfo> getDeviceInfo(@Url String url);

    @GET(ApiUrls.DEVICE_DETAILS + "{deviceId}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<DeviceInfo> getDeviceInformation(@Path("deviceId") String deviceId, @Header("X-Authorization-Firebase") String access_token);

    @GET("/api/mediametadata")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<CreatedVideo> getCreatedVideos(@Header("X-Authorization-Firebase") String access_token,@Query("time") long time, @Query("pageSize") long createdVideoPageSize, @Query("pageNumber") int pageNumber);

    @GET("/api/users/order/{orderId}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<OrderDetails> getOrderDetails(@Path("orderId") int orderId, @Header("X-Authorization-Firebase") String access_token);

    @POST("api/users/update-user")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<ResponseBody> updateUser(@Body UpdateUser updateUser);

    @POST("api/users/update-user-mobile")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<ResponseBody> updateUserMobile(@Header("X-Authorization-Firebase") String access_token, @Body UpdateUser updateUser);


    @DELETE("/api/userimage")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<JSONObject> deleteImage(@Header("X-Authorization-Firebase") String access_token);

    @GET("/api/users/{deviceId}/trip-url")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<TripData2Share> getTripUrl2Share(@Path("deviceId") String deviceId, @Query("ttl") long duration, @Header("X-Authorization-Firebase") String access_token);

    @GET("/api/users/{deviceId}/trip-url")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<TripData2Share> getTripUrl2Share(@Path("deviceId") String deviceId, @QueryMap HashMap<String, String> body, @Header("X-Authorization-Firebase") String access_token);

    @GET("api/devicesettings")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<DefaultSettings>> getSettings(@Query("timestamp") String timestamp, @Header("X-Authorization-Firebase") String access_token);

    @GET(ApiUrls.GET_ALL_DEVICES)
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<List<TrackerDeviceBean>>> getDevicesList(@Header("X-Authorization-Firebase") String access_token);

    @POST("/api/userinfo")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> sendFCMTokenToServer(@Body HashMap<String, String> body, @Header("X-Authorization-Firebase") String access_toke);

    @GET("/api/devices/pubnub-keys")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<PubNubKeysBean>> getPubNubKeys(@Header("X-Authorization-Firebase") String access_token);

    @GET("api/devicemedia/{deviceId}/{tripId}/getMedia")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<TripMediaResponse>> getTripMedia(@Path("deviceId") String deviceId, @Path("tripId") String tripId,
                                                         @Query("prepareMedia") boolean isPrepare,
                                                         @Query("camera") String camera,
                                                         @Header("X-Authorization-Firebase") String access_token);

    @GET(ApiUrls.GET_ALL_DEVICE_SETTING)
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<AllDevicesSettingResponse>> getSettingsNew(@Query("timestamp") String timestamp, @Header("X-Authorization-Firebase") String access_token);

    @POST("/api/devices")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<AddDeviceModelResponse> addDevice(@Body DeviceInformation deviceInformation, @Header("X-Authorization-Firebase") String access_token);

    @GET("api/devices/{deviceId}/driver-image/")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> getDriverImageApi(@Path("deviceId") long deviceId, @Query("tripId") String tripId, @Header("X-Authorization-Firebase") String access_token);

    @GET("api/devices/{deviceId}/driver-image/")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<ResponseBody> getDriverImageSyncApi(@Path("deviceId") long deviceId, @Query("tripId") String tripId, @Header("X-Authorization-Firebase") String access_token);

    @POST("api/devices/driver-image")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> getValidateDriverImageApi(@Body HashMap<String, String> body, @Header("X-Authorization-Firebase") String access_token);

    @POST("api/devices/{deviceId}/activate-stealth-mode")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> toggleStealthModeApi(@Path("deviceId") String deviceId, @Body StealthRequestModel body, @Header("X-Authorization-Firebase") String access_token);

    @POST("api/devices/{deviceId}/activate-stealth-mode")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> toggleStealthModeForTripOnlyApi(@Path("deviceId") String deviceId, @Query("stealthEnabled") boolean stealthEnabled, @Query("tripId") String stealthTime, @Query("stealthType") String stealthType, @Header("X-Authorization-Firebase") String access_token);

    @POST("api/devices/{deviceId}/hotspot")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> toggleWifiHotspotApiCall(@Path("deviceId") String deviceId, @Query("hotspotEnabled") boolean hotspotEnabled, @Header("X-Authorization-Firebase") String access_token);

    @DELETE("api/devices/{deviceId}/data")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> resetDeviceData(@Path("deviceId") String deviceId, @Header("X-Authorization-Firebase") String access_token);

    @GET("api/devices/{deviceId}/all-traveller-images/")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> getAllTravellerImagesApi(@Path("deviceId") long deviceId, @Query("tripId") String tripId, @Header("X-Authorization-Firebase") String access_token);

    @POST("/api/travellers")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> addTravellerProfileApi(@Body AddDriverImageRequestBody addDriverImageRequestBody, @Header("X-Authorization-Firebase") String access_token);

    @POST("/api/travellers/validate-image")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> validateDriverProfileImageApi(@Body HashMap<String, String> body, @Header("X-Authorization-Firebase") String access_toke);


    @POST("/api/devices/{deviceId}/hotspot/ssid")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> changeHptSpotSSID(@Path("deviceId") long deviceId, @Query("hotspotSsid") String hotspotSsid, @Header("X-Authorization-Firebase") String access_toke);

    @POST("/api/devices/{deviceId}/hotspot/password")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> changeHptSpotPwd(@Path("deviceId") long deviceId, @Query("hotspotPassword") String hotspotSsid, @Header("X-Authorization-Firebase") String access_toke);

    @GET("api/devices/{deviceId}/device-drivers")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> getDeviceDriversApi(@Path("deviceId") long deviceId, @Header("X-Authorization-Firebase") String access_token);


    @GET("/api/devices/{deviceId}/hotspot/users")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<List<HotSpotUser>>> getHotspotUsers(@Path("deviceId") long deviceId, @Header("X-Authorization-Firebase") String access_token);

    @PUT("/api/travellers/{deviceDriverId}/whitelist")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> toggleWhitelistForDeviceDriver(@Path("deviceDriverId") String deviceDriverId, @Query("whitelisted") boolean whitelisted, @Body StealthFaceRequestModel stealthRequestModel, @Header("X-Authorization-Firebase") String access_token);

    @DELETE("/api/travellers/{deviceDriverId}/device-driver")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> deleteDeviceDriver(@Path("deviceDriverId") String deviceDriverId, @Header("X-Authorization-Firebase") String access_token);

    @GET
    @Headers({"Accept:application/json", "Content-Type:application/json"})
    Call<GeocoderAddressBean> getAddress(@Url String url, @HeaderMap Map<String, String> headerMap);


    @Multipart
    @POST("/api/users/share-feedback")
    Observable<Response<ResponseBody>> shareFeedback(@Header("X-Authorization-Firebase") String access_token,
                                                     @Part("feedback") RequestBody feedback, @Part("type") RequestBody type,
                                                     @Part List<MultipartBody.Part> attachments);

    @GET("/api/users/signup-mobile-otp")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<ResponseBody> sendOTPOnMobile(@Query("mobileNumber") String mobileNumber);

    @GET("/api/devices/{id}/shareDevice")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<List<SharedUser>> getSharedUserList(@Path("id") long deviceId, @Header("X-Authorization-Firebase") String access_token);

    @POST("/api/sharedevicemedia/{deviceId}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> getMediaUrl2Share(@Path("deviceId") String deviceId, @Body HashMap<String, String> body, @Header("X-Authorization-Firebase") String access_token);

    @GET("/api/devices/{id}/diagnostic")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<DiagnosticCheckResponse>> deviceDiagnosys(@Path("id") String deviceId, @Header("X-Authorization-Firebase") String access_token);


    @POST("/api/devices/{id}/diagnostic")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> startDiagnostic(@Path("id") String deviceId,@Header("X-Authorization-Firebase") String access_token);

    @POST("/api/devices/onboarding/status")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Observable<Response<ResponseBody>> getDeviceOnBoardingStatus(@Body HashMap<String, ArrayList<String>> body, @Header("X-Authorization-Firebase") String access_token);
}
