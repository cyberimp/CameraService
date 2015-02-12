package su.bydlocoders.cameraservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.hardware.Camera;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class CameraHandler extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_CAPTURE = "su.bydlocoders.cameraservice.action.CAPTURE";
//    private static final String ACTION_BAZ = "su.bydlocoders.cameraservice.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_TIME = "su.bydlocoders.cameraservice.extra.TIME";
    private static final String EXTRA_NUM = "su.bydlocoders.cameraservice.extra.NUM";

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionCapture(Context context, int num, int time) {
        Intent intent = new Intent(context, CameraHandler.class);
        intent.setAction(ACTION_CAPTURE);
        intent.putExtra(EXTRA_NUM, num);
        intent.putExtra(EXTRA_TIME, time);
        context.startService(intent);
    }


    public CameraHandler() {
        super("CameraHandler");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_CAPTURE.equals(action)) {
                final int time = intent.getIntExtra(EXTRA_TIME, 15);
                final int num = intent.getIntExtra(EXTRA_NUM,1);
                handleActionCapture(num, time);
            }// else if (ACTION_BAZ.equals(action)) {
//                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
//                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
//                handleActionBaz(param1, param2);
//            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     * @param num
     * @param time
     */
    private void handleActionCapture(int num, int time) {
        Camera camera;
        camera = Camera.open();
        Camera.Parameters params = camera.getParameters();
        Log.d("camera", params.toString());
        camera.release();
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
