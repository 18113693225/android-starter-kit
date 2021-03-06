/**
 * Created by YuGang Yang on September 24, 2015.
 * Copyright 2007-2015 Laputapp.com. All rights reserved.
 */
package starter.kit.rx.app.feature.feed;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import starter.kit.rx.app.R;
import starter.kit.rx.app.model.entity.Feed;
import starter.kit.rx.app.widget.PhotoCollectionView;
import support.ui.adapters.EasyViewHolder;

public class FeedsMultiImageViewHolder extends EasyViewHolder<Feed> {

  @Bind(R.id.image_feed_user_avatar) SimpleDraweeView mAvatarView;
  @Bind(R.id.text_feed_username) TextView mUsernameTextView;
  @Bind(R.id.text_feed_content) TextView mContentTextView;
  @Bind(R.id.feed_photo_view) PhotoCollectionView mPhotoView;

  public FeedsMultiImageViewHolder(Context context, ViewGroup parent) {
    super(context, parent, R.layout.list_item_feed_image);
    ButterKnife.bind(this, itemView);
    mPhotoView.setLayoutManager(new GridLayoutManager(context, 3));
  }

  @Override public void bindTo(int position, Feed feed) {
    mAvatarView.setImageURI(feed.user.uri());
    mUsernameTextView.setText(feed.user.nickname);
    mContentTextView.setText(feed.content);
    mPhotoView.setData(feed.images);
  }
}
