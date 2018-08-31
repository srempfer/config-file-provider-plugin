package org.jenkinsci.plugins.configfiles.casc;

import org.jenkinsci.lib.configprovider.model.Config;
import org.jenkinsci.plugins.configfiles.xml.XmlConfig;

import hudson.Extension;
import io.jenkins.plugins.casc.impl.configurators.HeteroDescribableConfigurator;

/**
 * Configurator for the different {@link Config} types, e.g. {@link XmlConfig}.<br>
 * This is required because the {@link HeteroDescribableConfigurator} is only used for abstract types out of the box.
 *
 * @author srempfer
 *
 */
@Extension
public class ConfigConfigurator extends HeteroDescribableConfigurator<Config> {

    public ConfigConfigurator() {
        super(Config.class);
    }
}
