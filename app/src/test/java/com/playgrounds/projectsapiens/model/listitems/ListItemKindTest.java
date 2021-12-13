package com.playgrounds.projectsapiens.model.listitems;

import com.google.common.truth.Truth;

import org.junit.Test;

public class ListItemKindTest {
    @Test
    public void valueOf() {
        Truth.assertThat(ListItemKind.valueOf(ListItemKind.FEED_ITEM.id)).isEqualTo(ListItemKind.FEED_ITEM);
        Truth.assertThat(ListItemKind.valueOf(ListItemKind.TABOOLA_WIDGET.id)).isEqualTo(ListItemKind.TABOOLA_WIDGET);
        Truth.assertThat(ListItemKind.valueOf(ListItemKind.TABOOLA_FEED.id)).isEqualTo(ListItemKind.TABOOLA_FEED);
    }
}
