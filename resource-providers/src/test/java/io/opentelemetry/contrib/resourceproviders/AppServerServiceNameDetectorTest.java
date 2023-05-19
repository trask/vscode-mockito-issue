/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.contrib.resourceproviders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AppServerServiceNameDetectorTest {

  @Mock private AppServer appServer;

  @Test
  void detectNullServerClass() {
    AppServerServiceNameDetector detector = new AppServerServiceNameDetector(appServer);
    assertThat(detector.detect()).isNull();
  }
}
