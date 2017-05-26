 private void vidQuery(Context context) {
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Video.VideoColumns.DATA};
        Cursor c = context.getContentResolver().query(uri, projection, null, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                String path = c.getString(0);
                Log.d("VIDEO", path);
            }
            c.close();
        }
    }

    private void musQuery(Context context) {
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Audio.AudioColumns.DATA};
        Cursor c = context.getContentResolver().query(uri, projection, null, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                String path = c.getString(0);
                Log.d("AUDIO", path);
            }
            c.close();
        }
    }

    private void picQuery(Context context) {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Images.ImageColumns.DATA};
        Cursor c = context.getContentResolver().query(uri, projection, null, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                String path = c.getString(0);
                Log.d("IMAGE", path);
            }
            c.close();
        }
    }
