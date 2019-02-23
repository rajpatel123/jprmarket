package com.example.kishan.grofers.retrofit;


import com.camtrack.tracker.BuildConfig;
import com.camtrack.tracker.activities.stealthactivities.StealthFaceRequestModel;
import com.camtrack.tracker.activities.stealthactivities.StealthRequestModel;
import com.camtrack.tracker.firebaseanalytics.FirebaseEventLogger;
import com.camtrack.tracker.models.AddDriverImageRequestBody;
import com.camtrack.tracker.models.AllDevicesSettingResponse;
import com.camtrack.tracker.models.DeviceInformation;
import com.camtrack.tracker.models.GeocoderAddressBean;
import com.camtrack.tracker.models.HotSpotUser;
import com.camtrack.tracker.models.OrderDetails;
import com.camtrack.tracker.models.PubNubKeysBean;
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

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class RestClient {
    private static final String TAG = "RestClient";

    public static void getWalkingDirections(String url, Callback<Directions> callback) {
        Call<Directions> call = RetrofitClient.getClient().getWalkingDirections(url);
        call.enqueue(callback);
    }

    public static void getDeviceInformation(String deviceId, String access_token, Callback<DeviceInfo> callback) {
        RetrofitClient.getClient().getDeviceInformation(deviceId, access_token).enqueue(callback);
    }

    public static void sendOTPOnMobile(String mobileNumber, Callback<ResponseBody> callback) {
        RetrofitClient.getClient().sendOTPOnMobile(mobileNumber).enqueue(callback);
    }

    public static void getSharedUserList(long id, String access_token, Callback<List<SharedUser>> callback) {
        RetrofitClient.getClient().getSharedUserList(id, access_token).enqueue(callback);
    }

    public static void getCreatedVideos(String access_token, int createdVideoPageSize, int pageNumber, long time, Callback<CreatedVideo> callback) {
        RetrofitClient.getClient().getCreatedVideos(access_token,time,createdVideoPageSize,pageNumber).enqueue(callback);
    }

    public static void getOrderDetails(int orderId, String accessToken, Callback<OrderDetails> callback) {
        RetrofitClient.getClient().getOrderDetails(orderId, accessToken).enqueue(callback);
    }

    public static void deleteImage(String access_token, Callback<JSONObject> callback) {
        RetrofitClient.getClient().deleteImage(access_token).enqueue(callback);
    }

    public static void updateUser(UpdateUser updateUser, Callback<ResponseBody> callback) {
        RetrofitClient.getClient().updateUser(updateUser).enqueue(callback);
    }

    public static void updateUserMobile(String access_token, UpdateUser updateUser, Callback<ResponseBody> callback) {
        RetrofitClient.getClient().updateUserMobile(access_token, updateUser).enqueue(callback);
    }

    public static void addDevice(DeviceInformation deviceInformation, String token, Callback<AddDeviceModelResponse> callback) {
        RetrofitClient.getClient().addDevice(deviceInformation, token).enqueue(callback);
    }


    public static void getTripUrl2Share(String deviceId, long duration, String access_token, Callback<TripData2Share> callback) {
        RetrofitClient.getClient().getTripUrl2Share(deviceId, duration, access_token).enqueue(callback);
    }

    public static void getTripUrl2Share(String deviceId, HashMap<String, String> body, String access_token, Callback<TripData2Share> callback) {
        RetrofitClient.getClient().getTripUrl2Share(deviceId, body, access_token).enqueue(callback);
    }

    public static Observable<Response<DefaultSettings>> getSettings(String timestamp, String access_token) {
        return RetrofitClient.getRxClient().getSettings(timestamp, access_token);
    }

    public static Observable<Response<AllDevicesSettingResponse>> getSettingsNew(String timestamp, String access_token) {
        return RetrofitClient.getRxClient().getSettingsNew(timestamp, access_token);
    }

    public static Observable<Response<List<TrackerDeviceBean>>> getDevicesList(String access_token) {
        return RetrofitClient.getRxClient().getDevicesList(access_token);
    }

    public static Observable<Response<ResponseBody>> sendFCMTokenToServer(@Body HashMap<String, String> body, String access_token) {
        return RetrofitClient.getRxClient().sendFCMTokenToServer(body, access_token);
    }

    public static Observable<Response<PubNubKeysBean>> getPubNubKeys(String access_token) {
        return RetrofitClient.getRxClient().getPubNubKeys(access_token);
    }

    public static Observable<Response<TripMediaResponse>> getTripMedia(String deviceId, String tripId, boolean isPrepare, String camera, String access_token) {
        return RetrofitClient.getRxClient().getTripMedia(deviceId, tripId, isPrepare, camera, access_token);
    }

    public static Observable<Response<ResponseBody>> toggleStealthModeApi(String deviceId, StealthRequestModel body, String access_token) {
        return RetrofitClient.getRxClient().toggleStealthModeApi(deviceId, body, access_token);
    }

    public static Observable<Response<ResponseBody>> toggleStealthModeForTripOnlyApi(String deviceId, boolean stealthEnabled, String tripId, String stealthType, String access_token) {
        return RetrofitClient.getRxClient().toggleStealthModeForTripOnlyApi(deviceId, stealthEnabled, tripId, stealthType, access_token);
    }

    public static Observable<Response<ResponseBody>> getDriverImageApi(long deviceId, String tripId, String access_token) {
        return RetrofitClient.getRxClient().getDriverImageApi(deviceId, tripId, access_token);
    }

    public static void getDriverImageApi(long deviceId, String tripId, String access_token, Callback<ResponseBody> callback) {
        RetrofitClient.getClient().getDriverImageSyncApi(deviceId, tripId, access_token).enqueue(callback);
    }

    public static Observable<Response<ResponseBody>> getValidateDriverImageApi(@Body HashMap<String, String> body, String access_token) {
        return RetrofitClient.getRxClient().getValidateDriverImageApi(body, access_token);
    }

    public static Observable<Response<ResponseBody>> toggleWifiHotspotApiCall(String deviceId, boolean hotspotEnabled, String access_token) {
        return RetrofitClient.getRxClient().toggleWifiHotspotApiCall(deviceId, hotspotEnabled, access_token);
    }

    public static Observable<Response<ResponseBody>> resetDeviceData(String deviceId, String access_token) {
        return RetrofitClient.getRxClient().resetDeviceData(deviceId, access_token);
    }

    public static Observable<Response<ResponseBody>> getAllTravellerImagesApi(long deviceId, String tripId, String access_token) {
        return RetrofitClient.getRxClient().getAllTravellerImagesApi(deviceId, tripId, access_token);
    }

    public static Observable<Response<ResponseBody>> addTravellerProfileApi(AddDriverImageRequestBody addDriverImageRequestBody, String access_token) {
        return RetrofitClient.getRxClient().addTravellerProfileApi(addDriverImageRequestBody, access_token);
    }

    public static Observable<Response<ResponseBody>> validateDriverProfileImageApi(HashMap<String, String> body, String access_token) {
        return RetrofitClient.getRxClient().validateDriverProfileImageApi(body, access_token);
    }

    public static Observable<Response<ResponseBody>> changeHptSpotSSID(long deviceId, String ssid, String access_token) {
        return RetrofitClient.getRxClient().changeHptSpotSSID(deviceId, ssid, access_token);
    }

    public static Observable<Response<ResponseBody>> getDeviceDriversApi(long deviceId, String access_token) {
        return RetrofitClient.getRxClient().getDeviceDriversApi(deviceId, access_token);
    }

    public static Observable<Response<ResponseBody>> toggleWhitelistForDeviceDriver(String deviceDriverId, boolean whitelisted, StealthFaceRequestModel stealthRequestModel, String access_token) {
        return RetrofitClient.getRxClient().toggleWhitelistForDeviceDriver(deviceDriverId, whitelisted, stealthRequestModel, access_token);
    }

    public static Observable<Response<ResponseBody>> changeHptSpotPwd(long deviceId, String pwd, String access_token) {
        return RetrofitClient.getRxClient().changeHptSpotPwd(deviceId, pwd, access_token);
    }

    public static Observable<Response<List<HotSpotUser>>> getHotspotUsers(long deviceId, String access_token) {
        return RetrofitClient.getRxClient().getHotspotUsers(deviceId, access_token);
    }

    public static Observable<Response<ResponseBody>> deleteDeviceDriver(String deviceDriverId, String access_token) {
        return RetrofitClient.getRxClient().deleteDeviceDriver(deviceDriverId, access_token);
    }

    public static Observable<Response<ResponseBody>> shareFeedback(String access_token, RequestBody feedback, RequestBody type, List<MultipartBody.Part> attachments) {
        return RetrofitClient.getRxClient().shareFeedback(access_token, feedback, type, attachments);
    }


    public static Response<GeocoderAddressBean> getAddress(String url) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-Android-Package", BuildConfig.APPLICATION_ID);
        headerMap.put("X-Android-Cert", UtilsApp.getSignature());

        Call<GeocoderAddressBean> call = RetrofitClient.getClient().getAddress(url, headerMap);
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            String additionalDetail = null;
            FirebaseEventLogger.instance().logCatchEvent(TAG, e, additionalDetail);
        }
        return null;
    }

    public static Observable<Response<ResponseBody>> getMediaUrl2Share(String deviceId, HashMap<String, String> body, String access_token) {
        return RetrofitClient.getRxClient().getMediaUrl2Share(deviceId, body, access_token);
    }

    public static Observable<Response<DiagnosticCheckResponse>> getStatusDiagnostic(String deviceId, String access_token){
        return RetrofitClient.getRxClient().deviceDiagnosys(deviceId,access_token);
    }

    public static Observable<Response<ResponseBody>> startDiagnostic(String deviceId, String access_token){
        return RetrofitClient.getRxClient().startDiagnostic(deviceId,access_token);
    }

    public static Observable<Response<ResponseBody>> getDeviceOnBoardingStatus(@Body HashMap<String, ArrayList<String>> body, String access_token) {
        return RetrofitClient.getRxClient().getDeviceOnBoardingStatus(body, access_token);
    }
}



