/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.performanceanalyzer.commons.metrics.generator;


import org.opensearch.performanceanalyzer.commons.config.ConfigStatus;
import org.opensearch.performanceanalyzer.commons.metrics.generator.linux.LinuxOSMetricsGenerator;

public class OSMetricsGeneratorFactory {

    private static final String OS_TYPE = System.getProperty("os.name");

    public static OSMetricsGenerator getInstance() {

        if (isLinux()) {
            return LinuxOSMetricsGenerator.getInstance();
        } else {
            ConfigStatus.INSTANCE.setConfigurationInvalid();
        }

        return null;
    }

    private static boolean isLinux() {
        return OS_TYPE.toLowerCase().contains("linux");
    }
}
