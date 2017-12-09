package io.github.alexlondon07.finalproject.view.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;

import io.github.alexlondon07.finalproject.R;
import retrofit2.Call;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private TwitterLoginButton twitterLoginButton;
    private ImageView profilePhoto, profileBannerUrl;
    private TextView username, name, tweets, followers, followings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Twitter.initialize(this);
        setContentView(R.layout.activity_profile);


        loadView();
        loginTwitter(this);
    }

    private void loadView() {
        //Información del Usuario Logueado
        twitterLoginButton = findViewById(R.id.login_twitter);
        profilePhoto = findViewById(R.id.session_photo);

        username = findViewById(R.id.session_nickname);
        name = findViewById(R.id.session_name_user);
        tweets = findViewById(R.id.session_likes);
        followers = findViewById(R.id.session_followers);
        followings = findViewById(R.id.session_following);
    }

    private void loginTwitter(final Context context) {

        twitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession twitterSession = TwitterCore.getInstance().getSessionManager().getActiveSession();

                TwitterAuthToken authToken = twitterSession.getAuthToken();
                Call<User> userResult = TwitterCore.getInstance()
                        .getApiClient(twitterSession)
                        .getAccountService()
                        .verifyCredentials(true, true, true);

                userResult.enqueue(new Callback<User>() {
                    @Override
                    public void success(Result<User> result) {

                        Picasso.with(context)
                                .load(result.data.profileImageUrlHttps)
                                .resize(140, 150)
                                .centerCrop()
                                .into(profilePhoto);

                        username.setText(result.data.screenName);
                        name.setText(result.data.name);
                        tweets.setText(""+result.data.statusesCount);
                        followers.setText(""+result.data.followersCount);
                        followings.setText(""+result.data.friendsCount);
                    }

                    @Override
                    public void failure(TwitterException exception) {
                            Toast.makeText(ProfileActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
            @Override
            public void failure(TwitterException exception) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        twitterLoginButton.onActivityResult(requestCode,resultCode,data);
    }
}
