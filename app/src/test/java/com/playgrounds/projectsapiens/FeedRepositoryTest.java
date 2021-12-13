package com.playgrounds.projectsapiens;

import com.google.common.truth.Truth;
import com.playgrounds.projectsapiens.listitems.FeedListItem;
import com.playgrounds.projectsapiens.listitems.ListItem;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class FeedRepositoryTest {
    @Test
    public void convertFromServer() {
        FeedItemsFromServer fromServer = new FeedItemsFromServer();
        fromServer.description = "Description";
        fromServer.title = "Title";
        fromServer.thumbnailUrl = "https://thumb";
        FeedListItem item = FeedRepository.convertFrom(fromServer);
        Truth.assertThat(item.description).isEqualTo(fromServer.description);
        Truth.assertThat(item.title).isEqualTo(fromServer.title);
        Truth.assertThat(item.thumbnailUri).isEqualTo(fromServer.thumbnailUrl);
    }

    @Test
    public void mapPostsToArray() {
        ListItem[] posts;
        LinkedList<FeedItemsFromServer> itemsFromServer = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            FeedItemsFromServer item = new FeedItemsFromServer();
            item.description = "DESCRIPTION #" + i;
            item.title = "TITLE #" + i;
            item.thumbnailUrl = "https://link.to.thumbnail/?foo=" + i;
            itemsFromServer.add(item);
        }
        posts = FeedRepository.mapPostsToArray(itemsFromServer);
        Truth.assertThat(Arrays.stream(posts).allMatch(item -> item == null || item instanceof FeedListItem)).isTrue();
        Truth.assertThat(posts.length).isEqualTo(PositionResolverImpl.OVERALL_POSITIONS);
        Truth.assertThat(posts[PositionResolverImpl.INDEX_RESERVED_FOR_TABOOLA_1]).isNull();
        Truth.assertThat(posts[PositionResolverImpl.INDEX_RESERVED_FOR_TABOOLA_2]).isNull();
        HashSet<Integer> indicesWithItem = new HashSet<>();
        for (int i = 0; i < posts.length; i++) {
            indicesWithItem.remove(PositionResolverImpl.INDEX_RESERVED_FOR_TABOOLA_1);
            indicesWithItem.remove(PositionResolverImpl.INDEX_RESERVED_FOR_TABOOLA_2);
        }
        Truth.assertThat(indicesWithItem.stream().allMatch(index -> posts[index] instanceof FeedListItem)).isTrue();
    }
}
