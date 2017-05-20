private void dialogAdd() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_stream_layout);

        final EditText etName = (EditText) dialog.findViewById(R.id.et_name);
        final EditText etLink = (EditText) dialog.findViewById(R.id.et_link);
        TextView tvAdd = (TextView) dialog.findViewById(R.id.tvAdd);

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String link = etLink.getText().toString().trim();
                if (!name.equals("") && !link.equals("")) {
                    listStream.add(0, new MyStream(name, link));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(getActivity(), "Please enter the missing field", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }
