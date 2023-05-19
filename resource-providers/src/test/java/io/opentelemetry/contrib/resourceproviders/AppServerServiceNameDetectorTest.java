package io.opentelemetry.contrib.resourceproviders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppServerServiceNameDetectorTest {

  @Mock private AppServer appServer;

  @Test
  void test() {
    new AppServerServiceNameDetector(appServer).getName();
  }
}
