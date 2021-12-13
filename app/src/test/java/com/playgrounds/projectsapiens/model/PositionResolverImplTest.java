package com.playgrounds.projectsapiens.model;

import com.google.common.truth.Truth;
import com.playgrounds.projectsapiens.model.listitems.ListItemKind;

import org.junit.Test;

public class PositionResolverImplTest {

    @Test
    public void get() {
        PositionResolverImpl resolver = new PositionResolverImpl();

        // Huh?! No find in Java...
        for (int i = 0; i < PositionResolverImpl.OVERALL_POSITIONS; i++) {
            ListItemKind kind = ListItemKind.valueOf(resolver.get(i));
            switch (i) {
                case PositionResolverImpl.INDEX_RESERVED_FOR_TABOOLA_1:
                    Truth.assertThat(kind).isEqualTo(ListItemKind.TABOOLA_WIDGET);
                    break;
                case PositionResolverImpl.INDEX_RESERVED_FOR_TABOOLA_2:
                    Truth.assertThat(kind).isEqualTo(ListItemKind.TABOOLA_FEED);
                    break;
                default:
                    Truth.assertThat(kind).isEqualTo(ListItemKind.FEED_ITEM);
                    break;
            }
        }
    }
}
