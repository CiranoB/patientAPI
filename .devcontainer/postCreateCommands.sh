apt-get -y update
apt-get -y install git

# MAVEN_VERSION="3.9.9"
# MAVEN_HOME="/opt/apache-maven-$MAVEN_VERSION"

# wget "https://dlcdn.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz"
# tar -xvf "apache-maven-$MAVEN_VERSION-bin.tar.gz"
# mv "apache-maven-$MAVEN_VERSION" /opt/

# echo "export M2_HOME=$MAVEN_HOME" | tee -a /etc/profile.d/maven.sh
# echo "export PATH=\$M2_HOME/bin:\$PATH" | tee -a /etc/profile.d/maven.sh

# echo "source /etc/profile.d/maven.sh" >> "$HOME/.bashrc"
# source /etc/profile.d/maven.sh