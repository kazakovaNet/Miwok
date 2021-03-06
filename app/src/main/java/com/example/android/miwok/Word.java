package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn. It contains a default
 * translation, a Miwok translation, and an image for that word.
 */
public class Word {
  /** Default translation for the word */
  private String defaultTranslation;
  /** Miwok translation for the word */
  private String miwokTranslation;

  /** Image resource ID for the word */
  private int imageResourceId = NO_IMAGE_PROVIDED;

  /** Sound resource ID for the word */
  private int soundResourceId;

  /** Constant value that represents no image was provided for this word */
  private static final int NO_IMAGE_PROVIDED = -1;

  /**
   * Create a new Word object.
   *
   * @param defaultTranslation is the word in a language that the user is already familiar with
   *     (such as English)
   * @param miwokTranslation is the word in the Miwok language
   */
  public Word(String defaultTranslation, String miwokTranslation, int soundResourceId) {
    this.miwokTranslation = miwokTranslation;
    this.defaultTranslation = defaultTranslation;
    this.soundResourceId = soundResourceId;
  }

  /**
   * Create a new Word object.
   *
   * @param defaultTranslation is the word in a language that the user is already familiar with
   *     (such as English)
   * @param miwokTranslation is the word in the Miwok language
   * @param imageResourceId is the drawable resource ID for the image associated with the word
   */
  public Word(
      String defaultTranslation,
      String miwokTranslation,
      int imageResourceId,
      int soundResourceId) {
    this.miwokTranslation = miwokTranslation;
    this.defaultTranslation = defaultTranslation;
    this.imageResourceId = imageResourceId;
    this.soundResourceId = soundResourceId;
  }

  /** Get the default translation of the word. */
  public String getDefaultTranslation() {
    return defaultTranslation;
  }

  /** Get the Miwok translation of the word. */
  public String getMiwokTranslation() {
    return miwokTranslation;
  }

  /** Return the image resource ID of the word. */
  public int getImageResourceId() {
    return imageResourceId;
  }

  /** Returns whether or not there is an image for this word. */
  public boolean hasImage() {
    return imageResourceId != NO_IMAGE_PROVIDED;
  }

  /** Return the sound resource ID of the word. */
  public int getSoundResourceId() {
    return soundResourceId;
  }
    
    @Override
    public String toString() {
        return "Word{" +
                "defaultTranslation='" + defaultTranslation + '\'' +
                ", miwokTranslation='" + miwokTranslation + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", soundResourceId=" + soundResourceId +
                '}';
    }
}
